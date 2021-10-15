package io.github.noeppi_noeppi.libx.annotation.processor.meta;

import io.github.noeppi_noeppi.libx.annotation.processor.ProcessorEnv;
import org.apache.maven.artifact.versioning.DefaultArtifactVersion;

import javax.annotation.Nullable;

public class LibXAPEnv {

    @Nullable
    public static DefaultArtifactVersion minecraftVersion(ProcessorEnv env) {
        if (!env.options().containsKey("mod.properties.mc_version")) return null;
        return new DefaultArtifactVersion(env.options().get("mod.properties.mc_version"));
    }

    @Nullable
    public static DefaultArtifactVersion modVersion(ProcessorEnv env) {
        if (!env.options().containsKey("mod.properties.mod_version")) return null;
        return new DefaultArtifactVersion(env.options().get("mod.properties.mod_version"));
    }
    
    @Nullable
    public static Boolean release(ProcessorEnv env) {
        if (!env.options().containsKey("mod.properties.release")) return null;
        return Boolean.parseBoolean(env.options().get("mod.properties.release"));
    }
}
