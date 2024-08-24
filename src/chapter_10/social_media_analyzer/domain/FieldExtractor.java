package chapter_10.social_media_analyzer.domain;

@FunctionalInterface
public interface FieldExtractor<T> {
    Object[] extractFields(T item);
}
