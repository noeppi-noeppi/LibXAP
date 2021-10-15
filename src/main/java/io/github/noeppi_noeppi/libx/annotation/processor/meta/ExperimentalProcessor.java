package io.github.noeppi_noeppi.libx.annotation.processor.meta;

import io.github.noeppi_noeppi.libx.annotation.meta.Experimental;
import io.github.noeppi_noeppi.libx.annotation.meta.RemoveIn;
import io.github.noeppi_noeppi.libx.annotation.processor.Processor;
import org.apache.maven.artifact.versioning.DefaultArtifactVersion;

import javax.annotation.processing.RoundEnvironment;
import javax.lang.model.element.Element;
import javax.lang.model.element.TypeElement;
import javax.tools.Diagnostic;
import java.util.Set;

public class ExperimentalProcessor extends Processor {

    @Override
    public Class<?>[] getTypes() {
        return new Class[]{
                Experimental.class
        };
    }

    @Override
    public void run(Set<? extends TypeElement> annotations, RoundEnvironment roundEnv) {
        for (Element element : roundEnv.getElementsAnnotatedWith(Experimental.class)) {
            if (LibXAPEnv.release() == Boolean.TRUE) {
                this.messager().printMessage(Diagnostic.Kind.ERROR, "Releases may not contain experimental members.", element);
            }
        }
    }
}