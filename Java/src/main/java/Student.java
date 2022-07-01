public class Student {
    private String name;
    private String batch;
    String subjects[]= new String[5];

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBatch() {
        return batch;
    }

    public void setBatch(String batch) {
        this.batch = batch;
    }

    public String[] getSubjects() {
        return subjects;
    }

    public void setSubjects(String[] subjects) {
        this.subjects = subjects;
    }

    public String[] getTimings() {
        return timings;
    }

    public void setTimings(String[] timings) throws Exception {
        if (getSubjects().length == timings.length) {
            this.timings = timings;
        } else {
            throw new Exception("Timings and Subjects lengths are not equal");
        }
    }

    String timings[] = new String[5];

}
