package net.thumbtack.tyunkov.lessons;

import net.thumbtack.tyunkov.lessons.errorCodes.InstituteErrorCode;
import net.thumbtack.tyunkov.lessons.exceptions.InstituteException;
import org.apache.commons.lang3.StringUtils;

/**
 * Created by dmitry on 15.11.15.
 */
public class Institute {
    private String title;
    private String city;

    public Institute(String title, String city) throws InstituteException {

        setTitle(title);
        setCity(city);
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) throws InstituteException {
        if (StringUtils.isEmpty(title))
            throw new InstituteException(InstituteErrorCode.TITLE_INCORRECT.getErrorString());
        this.title = title;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) throws InstituteException {
        if (StringUtils.isEmpty(city))
            throw new InstituteException(InstituteErrorCode.CITY_INCORRECT.getErrorString());
        this.city = city;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Institute institute = (Institute) o;

        if (!title.equals(institute.title)) return false;
        return city.equals(institute.city);

    }

    @Override
    public int hashCode() {
        int result = title.hashCode();
        result = 31 * result + city.hashCode();
        return result;
    }

    public String toString() {
        return "title: " + title + " city: " + city;
    }
}
