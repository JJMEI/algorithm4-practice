package test.threadlocal;

import org.junit.Test;

public class SequenceNumber {

    private static ThreadLocal<Integer> seqNum = new ThreadLocal<Integer>(){
        public Integer initialValue()
        {
            return 0;
        }
    };

    public int getNextNum()
    {
        seqNum.set(seqNum.get()+1);
        return seqNum.get();
    }

    public static void main(String[] args)
    {
        SequenceNumber sequenceNumber = new SequenceNumber();

        TestClient testClient1 = new TestClient(sequenceNumber);
        TestClient testClient2 = new TestClient(sequenceNumber);
        TestClient testClient3 = new TestClient(sequenceNumber);

        testClient1.start();
        testClient2.start();
        testClient3.start();
    }

    private static class TestClient extends Thread
    {
        private SequenceNumber sequenceNumber;

        public TestClient(SequenceNumber sequenceNumber)
        {
            this.sequenceNumber = sequenceNumber;
        }

        public void run()
        {
            for(int i=0;i<3;i++)
            {
                System.out.println("thread[" + Thread.currentThread().getName()+"] sn["+sequenceNumber.getNextNum()+"]");
            }
        }

    }

}
