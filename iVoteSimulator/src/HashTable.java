/**
 * Created by Adrian on 10/7/2016.
 */
public class HashTable {
    //The array holding the HashTable's contents
    private HashEntry[] dataArray;
    //The amount of contents in HashTable
    private int size;

    public HashTable() {
        dataArray = new HashEntry[64];
        size = 0;
    }

    /**
     * Hashes the given key by converting the middle 5 numbers, or all of them if the length is less than 5,
     * of the given key into a char array and multiplying those
     * char values together to get an integer, then using modulus on that integer to get the array index.
     * @param key the value to be hashed.
     * @return the hashed value.
     */
    private int hash(String key) {
        int result=1;
        char[] myArray;
        if(key.length()>=5) {
            int mid = key.length() / 2;
            myArray = key.substring(mid - 2, mid + 2).toCharArray();
        }
        else{
            myArray=key.toCharArray();
        }

        for (int i=0;i<myArray.length;i++){
            result*= myArray[i];
        }
        return result % dataArray.length;
    }

    /**
     * Puts a HashEntry containing the specified key and HashValue at the specified key.
     * @param key value of the HashValue.
     * @param value The data to put into that particular spot in the HashTable.
     */
    public void put(String key, Student value) {
        if(size>=dataArray.length*.75) {
            reSize();
        }
        HashEntry entry = new HashEntry(value);
        int indexToPut = hash(key);
        HashEntry cursor = dataArray[indexToPut];
        if (cursor != null) {
            while(cursor.getNext() != null && cursor.getKey().equals(key) == false) {
                cursor = cursor.getNext();
            }
            if (cursor.getKey().equals(key) == false) {
                cursor.setNext(entry);
            }
            else {
                cursor.setValue(value);
            }
        }
        else {
            dataArray[indexToPut] = entry;
        }
        size++;
    }

    /**
     * Resize the dataArray to better accommodate more data.
     */
    private void reSize(){
        HashEntry[] newData = new HashEntry[dataArray.length];
        for(int i = 0; i < dataArray.length; i++) {
            newData[i] = dataArray[i];
        }
        dataArray = new HashEntry [dataArray.length*2];
        for(int index=0;index<newData.length;index++)
            if(newData[index]!=null) {
                if (newData[index].getNext()!=null) {
                    HashEntry temp = newData[index].getNext();
                    newData[index].removeNext();
                    while(temp!=null){
                        HashEntry temp2 = temp.getNext();
                        temp.removeNext();
                        put(temp.getKey(),temp.getValue());
                        temp=temp2;
                    }
                }
             put(newData[index].getKey(), newData[index].getValue());
            }
    }

    /**
     * Gets the HashValue of the specified HashEntry at the specified key.
     * @param key to get.
     * @return the Student,or HashValue, of the HashEntry.
     */
     public Student get(String key) {
        int indexToGet = hash(key);
        HashEntry cursor = dataArray[indexToGet];
        while(cursor != null && cursor.getKey().equals(key)==false) {
            cursor = cursor.getNext();
        }
        if (cursor == null) {
            return null;
        }
        return cursor.getValue();
    }

    /**
     * Removes all entries in the HashTable
     */
    public void wipe() {
        dataArray=new HashEntry[64];
        size=0;
    }

}
