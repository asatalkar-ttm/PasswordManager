# ProjectArista
Password Manager

Arista is a Sanskrit word which translates to safe, secure.

## Technologies Used :

* [Java](https://www.java.com/en/)
* [Maven](https://maven.apache.org)
* [Passy](https://www.passay.org/)
* [Gson](https://mvnrepository.com/artifact/com.google.code.gson/gson/2.8.5)
* [opencsv](http://opencsv.sf.net/)

## Download Chrome Password CSV from chrome settings :

Step 1: Export your data from Chrome
Before you export your data from Chrome, temporarily turn off any backup software you may be using, so the unencrypted export file isn’t backed up. Then follow these steps:

* Click the Chrome menu <img src="https://image.flaticon.com/icons/svg/61/61140.svg" width=18 height=18> in the toolbar and choose Settings.
* Click Passwords.
* Click <img src="https://image.flaticon.com/icons/svg/61/61140.svg" width=18 height=18> above the list of saved passwords and select “Export passwords”.
* Click “Export passwords”, and enter the password you use to log in to your computer if asked.
* Save the file in the folder where you cloned this project as "Chrome Passwords.csv"

## Classes in this program and their functionalities :

### Package arista :

1. Encryption: reads all the passwords from the "Chrome Passwords.csv" file and encrypts them using ```AES 256bit``` standard. Currently all the passwords are encrypted using the password phrase "Hello" located on line 17 in ```Encryption.java```. Please change this to a different string once you clone the repo.
2. Decryption: reads all the passwords from the "Chrome Passwords.csv" file and decrypts them using ```AES 256bit``` standard. Currently all the passwords are decrypted using the password phrase "Hello" located on line 17 in ```Decryption.java```. Please change this to a different string once you clone the repo.

### Package convert :

1. Csv: Reads the file "Chrome Passwords.csv" and creates an object of each record.
2. PasswordManager: This consists of the main class.

### Package service :

1. GeneratePassword: This generates a password with at least one upper-case character, one lower-case character, one symbol (special character) and one digit character. The sample passwordGenerator creates a password of length 16 charaters long. To generate a password use the command ```passwordGenerator.generatePassword(<length of the desired password in int>, <List of rules>)``` where ```passwordGenerator``` is an object of ```class PasswordGenerator```

## Executing the Program

Upon executing the program it displays a list of the following :

```
======================================================
Name : name
URL : url
Username : username
======================================================
```

Followed by a menu option :

```
What are you looking for ?
1. Name
2. URL
3. username
```

This will perform a search on the credentails you enter based on the option you choose
