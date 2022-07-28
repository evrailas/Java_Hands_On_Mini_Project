package Team3.JavaMiniProject.model;

import lombok.experimental.SuperBuilder;

@SuperBuilder
public abstract class BaseModel {

    private long id;

    public BaseModel(long id) {
        this.id = id;
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
