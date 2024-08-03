## Using Privilege Escalation to Run Commands with sudo
Command:
```sh
ansible server1 -i inventory -a "tail /var/log/nginx/error.log" --become
ansible server1 -i inventory.ini -a "tail /var/log/nginx/error.log" --become -K
```
### Exercise:

1. Use the --become option to execute a command that requires elevated privileges, such as viewing the Nginx error log.
