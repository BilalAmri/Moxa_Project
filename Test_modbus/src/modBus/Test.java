package modBus;

import java.io.*;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Date;

import net.wimpi.modbus.ModbusException;
import net.wimpi.modbus.ModbusIOException;
import net.wimpi.modbus.ModbusSlaveException;
import net.wimpi.modbus.io.ModbusTCPTransaction;
import net.wimpi.modbus.msg.WriteCoilRequest;
import net.wimpi.modbus.msg.ReadInputDiscretesRequest;
import net.wimpi.modbus.msg.ReadInputDiscretesResponse;
import net.wimpi.modbus.net.TCPMasterConnection;

public class Test {

	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		TCPMasterConnection con = null; // the connection
        ModbusTCPTransaction trans = null; // the transaction
        ReadInputDiscretesRequest rreq = null; // the read request
        ReadInputDiscretesResponse  rres = null; // the read response
        String s="wwww";
		
		 while (true){
	      
			 InetAddress inet = InetAddress.getByName("10.3.10.162");
	    	   
	    	     if(inet.isReachable(2000)) 
	    	     {
			 try{
	    	           // 2. Open the connection
	    	              con = new TCPMasterConnection(inet);
	    	             
	    	              con.setPort(502);
	    	              con.connect();
	    	              
	    	              System.out.println("Connected");
	    	              // 3r. Prepare the READ request
	    	             
	    	              rreq = new ReadInputDiscretesRequest(0,2);

	    	              // 4r. Prepare the READ transaction
	    	              trans = new ModbusTCPTransaction(con);
	    	              
	    	              trans.setRequest(rreq);
	    	              trans.execute();
	    	              rres = (ReadInputDiscretesResponse) trans.getResponse();
	    	            
	    	              System.out.println("Rotation Broche ->  " + "= "
	    	                      + rres.getDiscreteStatus(0));
	    	              System.out.println(" Alarme ->  " + "= "
	    	                      + rres.getDiscreteStatus(1)); 
	    	              con.close();
	    	              
	    	        }catch (Exception e){
	    	             e.printStackTrace(); }
	    	      
	    	     }
	    	     else 
	    	    	 System.out.println("NOT AVAILABLE");
    Date date =new Date();
    System.out.println(date.toLocaleString());
    if(!s.isEmpty()) System.out.println("CC WALID");
	      Thread.sleep(10000);
	    }
	
}
	}


