# Network Vulnerability Scanner

A Java-based security scanner that performs port scanning and vulnerability detection.

## Features
- **Real Port Scanning**: Uses TCP sockets to detect open ports
- **Banner Grabbing**: Captures service version information
- **Vulnerability Detection**: Identifies common security issues
- **Risk Assessment**: Calculates risk levels (LOW/MEDIUM/HIGH/CRITICAL)
- **Exploit Simulation**: Tests vulnerability exploitation

## Technical Details
- Scans common ports (21, 22, 80, 443, etc.)
- 200ms timeout per port for fast scanning
- OOP design with encapsulation and inheritance

## Usage
```java
Target target = new Target("192.168.1.1", "Server", "Linux");
target.scanPorts();
target.detectVulnerabilities();
target.generatereport();
```

## Note
This is an educational project. Always get permission before scanning networks.