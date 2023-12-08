public class Packet{
    private long sequence;
    private String protocol;
    private int port;

    public Packet(long sequence, String protocol, int port){
        this.sequence = sequence;
        this.protocol = protocol;
        this.port = port;
    }

    public long getSeq(){
        return this.sequence;
    }
    public void print(){
        System.out.println(sequence + " (" + protocol + " port " + port + ")");
    }
}
