package entities;

public class Space {
    private static int counter = 0;
    private boolean isBusy;
    private int id;

    public Space() {
        isBusy = false;
        id = ++counter;
    }

    public boolean isBusy() {
        return isBusy;
    }

    public void setBusy(boolean busy) {
        isBusy = busy;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Space space = (Space) o;

        if (isBusy != space.isBusy) return false;
        return id == space.id;
    }

    @Override
    public int hashCode() {
        int result = (isBusy ? 1 : 0);
        result = 31 * result + id;
        return result;
    }

    @Override
    public String toString() {
        return "Space{" +
                "isBusy=" + isBusy +
                ", id=" + id +
                '}';
    }
}
