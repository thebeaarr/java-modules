import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket ;
import java.time.LocalDate;
import java.util.ArrayList;
public class Target
{
	private String ipAddress; 
	private String hostname ;
	private String os ;
	private ArrayList<Integer>  openPorts ;
	private ArrayList<String> version_servers ;
	private ArrayList<String> vulnerabilities ; 
	private String risklevel ; 
	private LocalDate lastScanDate;
	private static int totalTargets ;


	public Target(String ipAddress , String hostname , String os )
	{
		this.ipAddress = ipAddress;
		this.hostname = hostname ;
		this.os = os ;
		this.risklevel ="low";		this.lastScanDate = LocalDate.now();
		this.vulnerabilities = new ArrayList<>();
		this.openPorts = new ArrayList<>();
		this.version_servers = new ArrayList<>();
		this.totalTargets++;
	}

	// public Target()
	// {
	// 	this.ipAddress = "0.0.0.0";
	// 	this.os = "unknown";
	// 	this.hostname = "who?";
	// 	this.lastScanDate = LocalDate.now();
	// 	this.vulnerabilities = new ArrayList<>();
	// 	this.openPorts = new ArrayList<>();
	// 	this.totalTargets++;
	// }
	public Target()
	{
		try
		{
			InetAddress local = InetAddress.getLocalHost();
			this.ipAddress = local.getHostAddress();
			this.hostname = local.getHostName();
			this.os = System.getProperty("os.name");
		}
		catch (Exception e)
		{
			this.ipAddress = "127.0.0.1";
			this.hostname = "unknown";
			this.os = "unknown";
		}

		this.risklevel = "LOW";
		this.lastScanDate = LocalDate.now();
		this.vulnerabilities = new ArrayList<>();
		this.openPorts = new ArrayList<>();
		this.version_servers = new ArrayList<>();

		totalTargets++;
	}

	public Target(Target obj)
	{
		this.ipAddress = obj.ipAddress;
		this.hostname = obj.hostname ;
		this.os = obj.os ;
		this.risklevel = obj.risklevel; 
		this.lastScanDate = LocalDate.now();
		this.version_servers = new ArrayList<>(obj.version_servers);
		this.vulnerabilities = new ArrayList<>( obj.vulnerabilities);
		this.openPorts = new ArrayList(obj.openPorts);
	}
	public ArrayList<String> getVulns()
	{
		return this.vulnerabilities;
	}
	public ArrayList<Integer> getOpenport()
	{
		return this.openPorts;
	}

	// let's just make it real and use some network programming 
	public void scanPorts()
	{
		System.out.println("scanning " + hostname + " ...");
		for (int port = 1; port < 8000; port++)
{
	try
	{
		Socket socket = new Socket();
		socket.connect(new InetSocketAddress(ipAddress, port), 200);
		socket.setSoTimeout(200);

		BufferedReader in = new BufferedReader(
			new InputStreamReader(socket.getInputStream())
		);

		String banner = in.readLine();

		openPorts.add(port);

		if (banner != null && !banner.isEmpty())
			version_servers.add("Port " + port + ": " + banner);
		socket.close();
	}
	catch (Exception e)
	{
	}
}
	this.lastScanDate = LocalDate.now();
		System.out.println("Found " + openPorts.size() + " open ports ");
	}

	// this part it was for the project but now not needed 
	// public void scanPorts()
	// {
	// 	Random rand = new Random();
	// 	int numPorts = rand.nextInt(5) + 3;
	// 	System.out.println("Scanning " + hostname + " (" + ipAddress + ")...");
	// 	int commonPorts = {21, 22, 23, 25, 80, 443, 445, 3306, 3389, 8080};
	
	// 	for (int i = 0; i < numPorts; i++) {
	// 		int port = commonPorts[rand.nextInt(commonPorts.length)];
	// 		if (!openPorts.contains(port))
	// 			openPorts.add(port);
	// 	}
	// 	this.lastScanDate = LocalDate.now();
	// 	System.out.println("Found " + openPorts.size() + " open ports: " + openPorts);
	// }
	// this can be imporved in another project but we will just make random 
	// for the part of vulns detection this is just a fake part im not in the process of detecting the vuls yet

	public void detectVulnerabilities()
	{
		for(int port : this.openPorts)
		{
			switch(port)
			{
				case 21:
					vulnerabilities.add("FTP - Unencrypted file transfer");
					break;
				case 22:
					vulnerabilities.add("SSH - Weak authentication detected");
					break;
				case 23:
					vulnerabilities.add("Telnet - Insecure protocol in use");
				break;
				case 445:
					vulnerabilities.add("SMB - EternalBlue vulnerability");
					break;
				case 3389:
					vulnerabilities.add("RDP - Remote Desktop exposed");
					break;
				case 3306:
					vulnerabilities.add("MySQL exposed without firewall");
					break;
				case 5432:
					vulnerabilities.add("PostgreSQL exposed to network");
					break;
			}
		}
		calculateLVL();
	}
	public void calculateLVL()
	{
		int riskc = this.vulnerabilities.size();
		if(riskc == 0)
			risklevel = "LOW";
		else if(riskc <= 2)
			risklevel = "MEDIUM";
		else if(riskc >= 3)
			risklevel = "HIGH";
	}
	public void generatereport()
	{
		System.out.println("===== SCAN REPORT =====");
		System.out.println("Target : [" + hostname + "][" + ipAddress + "]");
		System.out.println("OS :[" +  os + "]");
		System.out.println("Open Ports : " + openPorts);
		// for(int port : openPorts)
		// 	System.out.print(port + ",");
		// System.out.println("]");
		System.out.println("Vulnerabilities Found !");
		for(String vuln : this.vulnerabilities)
			System.out.println(vuln);
		System.out.println("risk level : " + risklevel );
		System.out.println("last scan date : " + lastScanDate);
		System.out.println("   =======================");
	}
	public void patchVulnerability(String vuln)
	{
		this.vulnerabilities.remove(vuln);
		calculateLVL();
		System.out.println(vuln + " patched!!");
	}


	@Override 
	public String toString()
	{
		return "[Target] : " + this.ipAddress + " [risk level ] : " + this.risklevel;
	}
	@Override
		public boolean equals(Object obj)
		{
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (!(obj instanceof Target))
				return false;
			Target other = (Target) obj;
			return this.ipAddress != null &&
					this.ipAddress.equals(other.ipAddress);
		}
}