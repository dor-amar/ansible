## Restarting Services

Command:
```sh
ansible webservers -i inventory.ini -m service -a "name=nginx state=restarted" --become -K
```
### Exercise:

1. Restart the nginx service on all web servers. Understand how to manage services with Ansible.



