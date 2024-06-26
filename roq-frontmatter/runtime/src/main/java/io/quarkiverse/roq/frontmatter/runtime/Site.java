package io.quarkiverse.roq.frontmatter.runtime;

import java.time.LocalDateTime;

import io.quarkiverse.roq.data.runtime.annotations.DataMapping;

@DataMapping("site")
public record Site(
        String title,
        String description,
        String link,
        String baseurl,
        String url) {

    public LocalDateTime time() {
        return LocalDateTime.now();
    }

}
