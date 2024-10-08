package io.quarkiverse.roq.frontmatter.runtime.model;

import jakarta.enterprise.inject.Vetoed;

import io.quarkiverse.roq.util.PathUtils;
import io.quarkus.qute.TemplateData;

@TemplateData
@Vetoed
public record RootUrl(String url, String rootPath) {
    public RootUrl(String url, String rootPath) {
        this.url = url;
        this.rootPath = PathUtils.removeTrailingSlash(rootPath);
    }

    public String absolute() {
        return PathUtils.join(url, rootPath);
    }

    public String relative() {
        return rootPath();
    }

    public RoqUrl resolve(String path) {
        return RoqUrl.fromRoot(this, path);
    }

    public RoqUrl join(String path) {
        return resolve(path);
    }

    @Override
    public String toString() {
        return rootPath();
    }
}
