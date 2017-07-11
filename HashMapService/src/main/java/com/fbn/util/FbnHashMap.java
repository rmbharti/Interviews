package com.fbn.util;

public class FbnHashMap <K, V> implements com.fbn.util.Map {
	     
    private Entry<K,V>[] table;   //Array of Entry.
    private int capacity= 4;  //Initial capacity of HashMap
    
    static class Entry<K, V> {
        Object key;
        Object value;
        Entry<K,V> next;
    
        public Entry(Object newKey, Object data, Entry<K,V> next){
            this.key = newKey;
            this.value = data;
            this.next = next;
        }
    }
    

   @SuppressWarnings("unchecked")
   public FbnHashMap(){
      table = new Entry[capacity];
   }

  

   /**
    * Method allows you put key-value pair in FbnHashMap.
    * If the map already contains a mapping for the key, the old value is replaced.
    * Note: method does not allows you to put null key though it allows null values.
    * Implementation allows you to put custom objects as a key as well.
    * Key Features: implementation provides you with following features:-
    *     >provide complete functionality how to override equals method.
    *  >provide complete functionality how to override hashCode method.
    * @param newKey
    * @param data
    */
   @Override
   public void put(Object newKey, Object data){
      if(newKey==null)
          return;    //does not allow to store null.
     
      //calculate hash of key.
      int hash=hash(newKey);
      //create new entry.
      Entry<K,V> newEntry = new Entry<K,V>(newKey, data, null);
     
      //if table location does not contain any entry, store entry there.
       if(table[hash] == null){
        table[hash] = newEntry;
       }else{
          Entry<K,V> previous = null;
          Entry<K,V> current = table[hash];
          
          while(current != null){ //we have reached last entry of bucket.
          if(current.key.equals(newKey)){           
              if(previous==null){  //node has to be insert on first of bucket.
                    newEntry.next=current.next;
                    table[hash]=newEntry;
                    return;
              }
              else{
                  newEntry.next=current.next;
                  previous.next=newEntry;
                  return;
              }
          }
          previous=current;
            current = current.next;
        }
        previous.next = newEntry;
       }
   }

   
   
   /**
    * Method returns value corresponding to key.
    * @param key
    */
   @Override
   public Object get(Object key){
       int hash = hash(key);
       if(table[hash] == null){
        return null;
       }else{
        Entry<K,V> temp = table[hash];
        while(temp!= null){
            if(temp.key.equals(key))
                return temp.value;
            temp = temp.next; //return value corresponding to key.
        }         
        return null;   //returns null if key is not found.
       }
   }





/**
    * Method removes key-value pair from FbnHashMap.
    * @param key
    */
   @Override
   public boolean remove(Object deleteKey){
      
      int hash=hash(deleteKey);
             
     if(table[hash] == null){
           return false;
     }else{
       Entry<K,V> previous = null;
       Entry<K,V> current = table[hash];
       
       while(current != null){ //we have reached last entry node of bucket.
          if(current.key.equals(deleteKey)){               
              if(previous==null){  //delete first entry node.
                    table[hash]=table[hash].next;
                    return true;
              }
              else{
                    previous.next=current.next;
                     return true;
              }
          }
          previous=current;
            current = current.next;
         }
       return false;
     }
   
   }
  

   /**
    * Method displays all key-value pairs present in FbnHashMap.,
    * insertion order is not guaranteed, for maintaining insertion order
    * refer LinkedFbnHashMap.
    * @param key
    */
   public void display(){
      
      for(int i=0;i<capacity;i++){
          if(table[i]!=null){
                 Entry<K, V> entry=table[i];
                 while(entry!=null){
                       System.out.print("{"+entry.key+"="+entry.value+"}" +" ");
                       entry=entry.next;
                 }
          }
      }             
   
   }
   /**
    * Method implements hashing functionality, which helps in finding the appropriate
    * bucket location to store our data.
    * This is very important method, as performance of FbnHashMap is very much
    * dependent on  this method's implementation.
    * @param deleteKey
    */
   private int hash(Object deleteKey){
       return Math.abs(deleteKey.hashCode()) % capacity;
   }

	 
	}
	 
	 
	/**
	public class CustomHashMapApp {
	     
	    public static void main(String[] args) {
	           FbnHashMap<Integer, Integer> FbnHashMap = new FbnHashMap<Integer, Integer>();
	           FbnHashMap.put(21, 12);
	           FbnHashMap.put(25, 121);
	           FbnHashMap.put(30, 151);
	           FbnHashMap.put(33, 15);
	           FbnHashMap.put(35, 89);
	 
	           System.out.println("value corresponding to key 21="
	                        + FbnHashMap.get(21));
	           System.out.println("value corresponding to key 51="
	                        + FbnHashMap.get(51));
	 
	           System.out.print("Displaying : ");
	           FbnHashMap.display();
	 
	           System.out.println("\n\nvalue corresponding to key 21 removed: "
	                        + FbnHashMap.remove(21));
	           System.out.println("value corresponding to key 51 removed: "
	                        + FbnHashMap.remove(51));
	 
	           System.out.print("Displaying : ");
	           FbnHashMap.display();
	 
	    }
	}
	 */
