router.factory('UserService', function($http, $cookies) {
    var userService = {};

    userService.singin = function (user) {
        var _authdata = btoa(user.email + ':' + user.password);
        $http.defaults.headers.common['Authorization'] = 'Basic ' + _authdata;
        return $http.post('/api/login')
            .then(function (response) {
                $cookies.put('id', response.data.id);
                $cookies.put('role', response.data.role);
                $cookies.put('signedIn', 'yes');

                return response;
            });

    };

    userService.getuser = function(userId){
        return $http.get('/api/user')
            .then(function(response){
                return response;
            });
    };

    return userService;
});