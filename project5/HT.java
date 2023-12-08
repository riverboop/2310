public class HT {
    private Packet[] hashTable;
    private int size;

    public HT(int size){
        this.size = size;
        this.hashTable = new Packet[size];
    }
    private int hash(long key){
        int hash = (int)(key % (long)size);
        return hash;
    }
    public Packet search(long key){
        int hash = hash(key);
        final int endpoint = hash;
        do {
            if (hashTable[hash] == null){
                hash++;
                continue;
            }
            if (hashTable[hash].getSeq() == key){
                return hashTable[hash];
            }
            hash++;
            if (hash == size)
                hash = 0;
        } while (hash != endpoint);
        System.out.println("packet not found");
        return null;
    }
    public void insert(Packet item){
        int hash = hash(item.getSeq());
        final int endpoint = hash;
        do {
            if (hashTable[hash] == null){
                hashTable[hash] = item;
                break;
            }
            hash++;
            if (hash == size)
                hash = 0;
        } while (hash != endpoint);
    }
    public void delete(long key){
        int hash = hash(key);
        final int endpoint = hash;
        do {
            if (hashTable[hash].getSeq() == key){
                hashTable[hash] = null;
                break;
            }
            hash++;
            if (hash == size)
                hash = 0;
        } while (hash != endpoint);
    }
    public void listAll(){
        hr();
        for (int i = 0; i<this.size;++i){
            if (hashTable[i] != null)
                hashTable[i].print();
        }
        hr();
    }
	private void hr(){
		System.out.println("-------------------------------------------------------------");
	}
}
