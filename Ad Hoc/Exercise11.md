## Restarting Servers

Command:
```sh
ansible webservers -i inventory.ini -a "/sbin/reboot" --become -K
```
### Exercise:

1. Reboot all servers in a group. Use this command carefully as it will disrupt running applications.