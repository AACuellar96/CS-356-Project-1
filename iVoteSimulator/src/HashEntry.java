public class HashEntry {
    // The actual student in the HashEntry
    private Student value;
    // The HashEntry following this one
    private HashEntry next;

    public HashEntry(Student value) {
        this.value = value;
    }

    //Returns the key of HashEntry
    public String getKey() {
        return value.getSID();
    }

    // Get the value of HashEntry
    public Student getValue() {
        return this.value;
    }

    // Set the value of HashEntry
    public void setValue(Student value) {
        this.value = value;
    }

    // Get the next HashEntry after this HashEntry
    public HashEntry getNext() {
        return this.next;
    }

    // Set the next HashEntry after this HashEntry
    public void setNext(HashEntry next) {
        this.next = next;
    }
    //Removes the next HashEntry after this HashEntry
    public void removeNext(){
        next = null;
    }
}
