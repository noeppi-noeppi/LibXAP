package io.github.noeppi_noeppi.libx.annotation.processor.meta;

import org.apache.maven.artifact.versioning.DefaultArtifactVersion;

import javax.annotation.Nullable;
import java.util.Optional;

@SuppressWarnings({"OptionalUsedAsFieldOrParameterType", "OptionalAssignedToNull"})
public class LibXAPEnv {

    private static Optional<DefaultArtifactVersion> minecraftVersion = null;
    private static Optional<DefaultArtifactVersion> modVersion = null;
    private static Optional<Boolean> release = null;

    @Nullable
    public static DefaultArtifactVersion minecraftVersion() {
        if (minecraftVersion == null) {
            minecraftVersion = getVersion("libx.ap.minecraft");
        }
        return minecraftVersion.orElse(null);
    }

    @Nullable
    public static DefaultArtifactVersion modVersion() {
        if (modVersion == null) {
            modVersion = getVersion("libx.ap.mod");
        }
        return modVersion.orElse(null);
    }
    
    @Nullable
    public static Boolean release() {
        if (release == null) {
            release = getProperty("libx.ap.release").map(Boolean::parseBoolean);
        }
        return release.orElse(null);
    }

    private static Optional<DefaultArtifactVersion> getVersion(String property) {
        return getProperty(property).flatMap(ver -> {
            try {
                return Optional.of(new DefaultArtifactVersion(ver));
            } catch (Exception e) {
                System.err.println("LibX AP: " + property + " is invalid.");
                return Optional.empty();
            }
        });
    }

    private static Optional<String> getProperty(String property) {
        String value = System.getProperty(property);
        if (value != null) {
            return Optional.of(value);
        } else {
            System.err.println("LibX AP: " + property + " not set.");
            return Optional.empty();
        }
    }
}
