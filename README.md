# KinderPlan
**API Dodumentation**
* [login](documentation/login.md)
* [user](documentation/user.md)
* [signup](documentation/signup.md)

**Package Information**
* **authentication**
    * `Creates new session,  returns current session and clears all sessions. Stores all sessions in an concurrent hash map.`

* **controller**
    * `API init and implementation`

* **dao**
    * `Data access object. Sql queries that access the database are written here.`

* **dto**
    * `Data transfer object. Intermediate layer between entity and json response. Define this object to send only the data you really need to and skip or hide unnecessary information. `

* **entity**
    * `Class representation of database tables.`

* **error**
    * `Custom error messages declaration.`

* **exception**
    * `Custom exception messages declaration.`

* **mapper**
    * `Maps entity into dto.`

* **validator**
    * `Validates request data.`



**Exception List**
* **User:**

    * EmailAlreadyInUseException
        * `HttpStatus.CONFLICT (409)`
    * EmailUnverifiedException
        * `HttpStatus.FORBIDDEN (403)`
    * ForbiddenException
        * `HttpStatus.FORBIDDEN (403)`
    * NotAuthenticatedException
        * `HttpStatus.UNAUTHORIZED (401)`
    * UserAlreadyExistsException
        * `HttpStatus.CONFLICT (409)`
    * UserAlreadyVerifiedException
        * `HttpStatus.CONFLICT (409)`
    * UserNotFoundException
        * `HttpStatus.NOT_FOUND (404)`



* **General:**

    * BadRequestException
        * `insert handler info here`
    * NotAuthorizedException
        * `HttpStatus.CONFLICT (409)`
    * ValidationException
        * `HttpStatus.BAD_REQUEST (400)`

**Error message List**
* **UserError.java:**

    * USER_DOES_NOT_EXIST("User does not exist.")
    * INVALID_DATA("Invalid data.")
    * MISSING_DATA("Missing data.")
    * USER_ALREADY_VERIFIED("User is already verified.")
    * UNAUTHORIZED("Unauthorized user.")
    * NOT_AUTHENTICATED("User is not authenticated.")
    * EMAIL_ALREADY_IN_USE("Email is already in use.")
    * NEW_PASSWORD_DO_NOT_DIFFER("New password must differ with the old password.")
    * PASSWORD_MISSMATCH("Password is invalid.")

* **UserLoginError.java:**

    * MISSING_DATA("Email or password is missing.")
    * INVALID_DATA("Invalid data.")
    * INVALID_CREDENTIALS("Username and password do not match.")
    * USER_NOT_EMAIL_VERIFIED("User has not been verified yet.")

* **UserLoginError.java:**

    * MISSING_DATA("Required attributes are missing.")
    * INVALID_DATA("Invalid data.")
    * EMAIL_ALREADY_USED("Email is already in use.")
