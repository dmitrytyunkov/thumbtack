package net.thumbtack.tyunkov.lessons;

import net.thumbtack.tyunkov.lessons.errorCodes.GroupErrorCode;
import net.thumbtack.tyunkov.lessons.exceptions.GroupException;
import net.thumbtack.tyunkov.lessons.fifth.Trainee;
import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;

/**
 * Created by dmitry on 15.11.15.
 */
public class Group {
    private String title;
    private Trainee[] trainees;

    public Group(String title, Trainee[] trainees) throws GroupException {
        setTitle(title);
        setTrainees(trainees);
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) throws GroupException {
        if (StringUtils.isEmpty(title))
            throw new GroupException(GroupErrorCode.TITLE_INCORRECT.getErrorString());
        this.title = title;
    }

    public Trainee[] getTrainees() {
        return trainees;
    }

    public void setTrainees(Trainee[] trainees) throws GroupException {
        if (trainees == null || trainees.length == 0)
            throw new GroupException(GroupErrorCode.TRAINEE_INCORRECT.getErrorString());
        this.trainees = trainees;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Group group = (Group) o;

        if (!title.equals(group.title)) return false;
        // Probably incorrect - comparing Object[] arrays with Arrays.equals
        return Arrays.equals(trainees, group.trainees);

    }

    @Override
    public int hashCode() {
        int result = title.hashCode();
        result = 31 * result + Arrays.hashCode(trainees);
        return result;
    }
}
