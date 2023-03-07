# Using PMD

Pick a Java project from Github (see the [instructions](../sujet.md) for suggestions). Run PMD on its source code using any ruleset. Describe below an issue found by PMD that you think should be solved (true positive) and include below the changes you would add to the source code. Describe below an issue found by PMD that is not worth solving (false positive). Explain why you would not solve this issue.

## Answer
![image](https://user-images.githubusercontent.com/119609091/223380687-079d5b80-ac3d-4f8e-af3b-06d55721c291.png)
Un true positive :  	Use equals() to compare object references. => il faut utiliser .equals() au lieu de == pour comparer des objets.
Un false positive :  	The final local variable name 'EXPECTED_OUT' doesn't match '[a-z][a-zA-Z0-9]*' => Il est courrant d'utiliser des nom en capital pour des données statiques. La convention utilisée ne pose pas de problèmes et est uniforme dans le projet (plusieurs fois la présence du warning).
