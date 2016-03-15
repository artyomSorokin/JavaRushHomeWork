package com.javarush.test.level35.lesson10.bonus01;

import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Modifier;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashSet;
import java.util.Set;

/* ClassLoader - что это такое?
Реализуйте логику метода getAllAnimals.
Аргумент метода pathToAnimals - это абсолютный путь к директории, в которой хранятся скомпилированные классы.
Путь не обязательно содержит / в конце.
НЕ все классы наследуются от интерфейса Animal.
НЕ все классы имеют публичный конструктор без параметров.
Только для классов, которые наследуются от Animal и имеют публичный конструктор без параметров, - создать по одному объекту.
Добавить созданные объекты в результирующий сет и вернуть.
Метод main не участвует в тестировании.
*/
public class Solution {
    public static void main(String[] args) {
        Set<? extends Animal> allAnimals = getAllAnimals("C://pathToClasses/");
        System.out.println(allAnimals);
    }

    public static Set<? extends Animal> getAllAnimals(String pathToAnimals) {
        Set<Animal> set = new HashSet<>();
        if (!(pathToAnimals.endsWith("\\")) && !(pathToAnimals.endsWith("/")))
        {
            pathToAnimals = pathToAnimals + "/";
        }

        File directory = new File(pathToAnimals);

        String[] classFilterFile = directory.list(new FilenameFilter()
        {
            @Override
            public boolean accept(File dir, String name)
            {
                return name.toLowerCase().endsWith(".class");
            }
        });

        for (String str : classFilterFile)
        {
            try
            {
                final String finalPathtoAnimals = pathToAnimals;

                ClassLoader classLoader = new ClassLoader()
                {
                    @Override
                    protected Class<?> findClass(String name) throws ClassNotFoundException
                    {
                        String className = finalPathtoAnimals + name + ".class";
                        Path path = Paths.get(className);
                        try
                        {
                            byte[] buffer = Files.readAllBytes(path);
                            return defineClass(null, buffer, 0, buffer.length);
                        }
                        catch (IOException e)
                        {
                            return super.findClass(name);
                        }
                    }
                };


                String subName = str.substring(0, str.length() - 6);
                Class clazz = classLoader.loadClass(subName);
                boolean hasInterface = false;
                Class[] interfaces = clazz.getInterfaces();
                for (Class n : interfaces)
                {
                    if (n.equals(Animal.class))
                    {
                        hasInterface = true;
                        break;
                    }
                }

                if (!hasInterface) continue;

                boolean hasConstructor = false;

                Constructor[] constructors = clazz.getConstructors();
                for (Constructor constr : constructors)
                {
                    if (Modifier.isPublic(constr.getModifiers()) && constr.getParameterTypes().length == 0)
                    {
                        hasConstructor = true;
                    }
                }

                if (!hasConstructor) continue;

                set.add((Animal) clazz.newInstance());
            }

            catch (Exception e)
            {

            }
        }
        return set;
    }
}
