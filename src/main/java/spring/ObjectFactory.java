package spring;

public interface ObjectFactory {
    <T> T createObject(Class <T> type);
}
