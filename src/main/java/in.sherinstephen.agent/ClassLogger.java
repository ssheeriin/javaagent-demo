package in.sherinstephen.agent;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.ProtectionDomain;
import java.lang.instrument.*;
public class ClassLogger implements ClassFileTransformer {

    @Override
    public byte[] transform(ClassLoader classLoader, String className, Class<?> redefinedClass,
            ProtectionDomain protectionDomain, byte[] classFileBuffer) {
        try {
            Path path = Paths.get("classes/" + className + ".class");
            Files.write(path, classFileBuffer);
        } catch (Throwable t) {
            t.printStackTrace();
        }

        return classFileBuffer;

    }
}