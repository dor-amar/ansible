## Adjusting Connection Options
Command:
```sh
ansible all -i inventory.ini -m ping --private-key=/path/to/custom_id
```
### Exercise:

1. Modify the command to use a specific SSH user and private key. Test the connection to your Ansible hosts with these settings.

