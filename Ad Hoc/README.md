# Ansible Ad Hoc Commands Exercises

This repository contains exercises for practicing Ansible ad hoc commands. Each exercise demonstrates a specific task you can perform using Ansible without the need for a playbook. These tasks range from testing connectivity to managing services and packages on remote servers.

## Prerequisites

Before starting the exercises, ensure you have the following:

1. **Ansible Installed**: Ansible must be installed on your control node (your local machine or a dedicated server).
2. **SSH Access**: SSH access to the target servers is required. Ensure your SSH keys are correctly set up and accessible.

## Inventory File

The `inventory.ini` file lists the target servers that Ansible will manage. It should include the IP addresses or hostnames of the servers and the username used for SSH access.

### Example `inventory.ini`

```ini
[webservers]
203.0.113.111 ansible_user=sammy ansible_ssh_private_key_file=/path/to/private/key
203.0.113.112 ansible_user=sammy ansible_ssh_private_key_file=/path/to/private/key
```