public class packetRepository {
    public static void main(String[] args){
        HT packetTable = new HT(8);
        long specialKey = (long) (Math.random() * 429496729L);
        packetTable.insert(new Packet(specialKey, "UDP", 22));
        packetTable.insert(new Packet((long) (Math.random() * 429496729L), "TCP", 80));
        packetTable.insert(new Packet((long) (Math.random() * 429496729L), "TCP", 80));
        packetTable.insert(new Packet((long) (Math.random() * 429496729L), "TCP", 80));
        packetTable.insert(new Packet((long) (Math.random() * 429496729L), "TCP", 80));
        packetTable.insert(new Packet((long) (Math.random() * 429496729L), "TCP", 80));
        packetTable.insert(new Packet((long) (Math.random() * 429496729L), "TCP", 80));
        packetTable.listAll();
        packetTable.search(specialKey).print();
        packetTable.delete(specialKey);
        packetTable.listAll();
        packetTable.search(1);
    }
}
