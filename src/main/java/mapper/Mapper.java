package mapper;

/**
 * @author oksanapoliakova on 19.08.2023
 * @projectName JUnitTestProject
 */
public interface Mapper <F, T> {
    T map(F object);
}
