
router.controller('parentSignupController', function($scope, $cookies, UserService){

    $scope.credentials = {
        email: '',
        password: '',
        rep_password: '',
        first_name: '',
        last_name: '',
        phone_number: '',
        latitude: '',
        longitude: '',
        address: '',
        role: ''
    };

    $scope.vaildateEmail = function(email) {
        var re = /^(([^<>()\[\]\\.,;:\s@"]+(\.[^<>()\[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
        return re.test(email);
    };


    $scope.signup = function() {

        $scope.options = {
            types: 'geocode',
            watchEnter: true,
            country: 'gr'
        };


        var request = {
            email: $scope.credentials.email,
            password: $scope.credentials.password,
            repassword: $scope.credentials.rep_password,
            role: 'parent',
            name: $scope.credentials.first_name,
            surname: $scope.credentials.last_name,
            phone: $scope.credentials.phone_number,
            latitude: $scope.credentials.latitude,
            longitude: $scope.credentials.longitude,
            address: $scope.geoloc,
            parent: {
                points: 0
            }
        };

        var address = $scope.details.geometry.location;

        request.latitude = address.lat();
        request.longitude = address.lng();

        console.log(request);

        UserService.createUser(request)
            .then(function(response){
                console.log(response)

            }, function(error){
                console.log(error);
            });


    }
});