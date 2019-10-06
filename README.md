# Bashboard - Dashboard For Developers
![](/visuals/Bashboard-command-example.gif)

## About
**Interactive bookmark manager** made for developers! Bashboard enables you to **use _bash_-like commands to navigate through your website bookmarks.**  
The goal of this project was to create a **fun enviroment for organizing bookmarks** on my laptop.  
Additionally, when deployed to a remote server, it will give user the **leisure of having all bookmarks available on any device which has internet access.**

## Test it out!
Here is the link to the application: https://bashboard.herokuapp.com  
*Please be aware that the application is running on servers provided by Heroku, meaning it can result in an approximately 15 second delay each time it is being deployed after being unused for a while.*

## Command Form
Below is an example of what a bashboard command might look like.  

![](/visuals/Bashboard%20-%20command%20example.png)

This **command form has to be respected in order for the command to be parsed properly**. There is also one more property of the command form that can be used for creating commands. That is - you can **append infinitely many (ap & a) tags and values on the root argument**.
Each command declared with a prefix (-c) has a list of applicable modificators and their arguments.

## Currently Implemented Commands
| Command | Description |
| --- | --- |
| **ls**  | Display all command - displays all bookmarks | 
| **opn**  | Open command - opens a bookmark | 


## Currently Implemented Modificators (Argument Prefixes)
| Modificator | Description |
| --- | --- |
| **rgx** | Regular Expression (regex) modificator - Implies that its argument will have to be contained inside website path  |
| **tag** | Tag modificator - Implies that its argument will be the tag searched for in page semantics (Learning,Blog,Chill,Business..)|



## Interactive Design
![](/visuals/Bashboard-welcomescreen.gif)

![](/visuals/Bashboard-open-page.gif)



## Authors

* **Jurica Kenda** - *Initial work* - [JuricaKenda](https://github.com/juricaKenda)

## License

This project is licensed under the MIT License - see the [LICENSE.md](LICENSE.md) file for details
