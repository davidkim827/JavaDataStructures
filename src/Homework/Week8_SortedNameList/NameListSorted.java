package Homework.Week8_SortedNameList;

/**
 * Created by dk on 10/15/2017.
 */
public class NameListSorted {
    private LLNode firstNode;
    private int numElements;

    public NameListSorted(Name name) {
        numElements = 0;
        firstNode = null;
    }

    public int size() {
        return numElements;
    }

    public boolean isEmpty() {
        return firstNode == null;
    }

    public boolean isFull() {
        return false;
    }

    public void add(Name name) {

        LLNode currentLocation = firstNode;
        LLNode prevLoc = null;
        LLNode newNode = new LLNode(name, null);

        if (firstNode == null) {
            this.firstNode = newNode;
        } else {
            while (currentLocation != null && currentLocation.getName().getLastName().compareTo(newNode.getName().getLastName()) < 0) {
                prevLoc = currentLocation;
                currentLocation = currentLocation.getNext();
            }
            if (prevLoc != null) {
                newNode.setNext(currentLocation);
                prevLoc.setNext(newNode);
            } else {
                newNode.setNext(currentLocation);
                firstNode = newNode;
            }
        }

        numElements++;
    }

    public void insert(Name name) {
        LLNode currentLocation = firstNode;
        LLNode prevLoc = null;
        LLNode newNode = new LLNode(name, null);

        while (currentLocation != null && currentLocation.getName().getLastName().compareTo(newNode.getName().getLastName()) < 0) {
            prevLoc = currentLocation;
            currentLocation = currentLocation.getNext();
        }
        if (prevLoc != null) {
            newNode.setNext(currentLocation);
            prevLoc.setNext(newNode);
        } else {
            newNode.setNext(currentLocation);
            firstNode = newNode;
        }

        numElements++;
    }


    public void search(Name name) {
        LLNode currentLocation = firstNode;
        int index = 0;

        while (currentLocation != null) {
            if (currentLocation.getName().equals(name)) {
                break;
            } else {
                currentLocation = currentLocation.getNext();
                index++;
            }
        }
        System.out.println(index);
    }

    public void get(int index) {

        LLNode currentLocation = firstNode;
        int indexCount = 0;
        String firstName = null;
        String lastName = null;

        while (currentLocation != null) {
            if (indexCount == index) {
                firstName = currentLocation.getName().getFirstName();
                lastName = currentLocation.getName().getLastName();
            }
            indexCount++;
            currentLocation = currentLocation.getNext();
        }

        System.out.print(firstName + " " + lastName);
    }

    public void remove(int index) {
        LLNode currentLocation = firstNode;
        LLNode previousLoc = firstNode;
        int indexCount = 0;

        if (index == 0)
            firstNode = firstNode.getNext();

        if (index == size() - 1) {
            while (currentLocation != null) {
                previousLoc = currentLocation;
                currentLocation = currentLocation.getNext();
            }
            previousLoc.setNext(null);
        }

        if (index > 0 && index < size() - 1) {
            while (indexCount < index - 1) {
                previousLoc = previousLoc.getNext();
                indexCount++;
            }

            LLNode indexLocation = previousLoc.getNext();
            previousLoc.setNext(indexLocation.getNext());
            indexLocation = null;
        }

        numElements--;
    }

    public void remove(Name name) {
        LLNode currentLocation = firstNode;
        LLNode previousLoc = null;


        while (currentLocation.getNext() != null) {
            previousLoc = currentLocation;
            if (currentLocation.getName().equals(name) && currentLocation == firstNode) {
                firstNode = firstNode.getNext();
                break;
            }
            if (currentLocation.getName().getFirstName().compareTo(name.getFirstName()) == 0 && currentLocation.getName().getLastName().compareTo(name.getLastName()) == 0) {
                currentLocation = currentLocation.getNext();
                break;
            }
            previousLoc = currentLocation;
            currentLocation = currentLocation.getNext();
        }

        numElements--;
    }

    public void removeAll() {
        firstNode = null;
    }

    public void print() {
        LLNode firstNode = this.firstNode;
        while (firstNode != null) {
            System.out.println(firstNode.getName().getFirstName() + " " + firstNode.getName().getLastName());
            firstNode = firstNode.getNext();
        }
    }

    public void print(String prefix) {
        LLNode firstNode = this.firstNode;
        while (firstNode != null) {
            if (firstNode.getName().getLastName().startsWith(prefix)) {
                System.out.print(firstNode.getName().getFirstName() + " " + firstNode.getName().getLastName());
            }
            firstNode = firstNode.getNext();
        }
    }
}

