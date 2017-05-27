router.factory('UserService', function($http, $cookies) {
    var userService = {};

    userService.login = function (user) {
        return $http.post('/api/login', user)
            .then(function (response) {
                $cookies.put('id', response.data.id);
                $cookies.put('role', response.data.role);
                $cookies.put('signedIn', 'yes');
                $cookies.put('authToken', response.data.authToken);

                return response;
            });

    };

    userService.getuser = function(userId, authToken){
        return $http.get('/api/user/' + userId, {headers: {'authToken': authToken}})
            .then(function(response){
                return response;
            });
    };

    return userService;
});