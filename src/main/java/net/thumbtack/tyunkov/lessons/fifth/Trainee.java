package net.thumbtack.tyunkov.lessons.fifth;

import org.apache.commons.lang3.StringUtils;

/**
 * Created by dmitry on 01.11.15.
 */
public class Trainee {
    String name, lastName;
    int mark;

    public Trainee(String name, String lastName, int mark) throws TraineeException {
        setName(name);
        setLastName(lastName);
        setMark(mark);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) throws TraineeException {
        if (StringUtils.isEmpty(name))
            throw new TraineeException(TraineeErrorCode.NAME_INCORRECT.getErrorString());
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) throws TraineeException {
        if (StringUtils.isEmpty(lastName))
            throw new TraineeException(TraineeErrorCode.LAST_NAME_INCORRECT.getErrorString());
        this.lastName = lastName;
    }

    public int getMark() {
        return mark;
    }

    public void setMark(int mark) throws TraineeException {
        if (mark < 1 || mark > 5)
            throw new TraineeException(TraineeErrorCode.MARK_INCORRECT.getErrorString());
        this.mark = mark;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Trainee trainee = (Trainee) o;

        if (mark != trainee.mark) return false;
        if (!name.equals(trainee.name)) return false;
        return lastName.equals(trainee.lastName);

    }

    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + lastName.hashCode();
        result = 31 * result + mark;
        return result;
    }
}
