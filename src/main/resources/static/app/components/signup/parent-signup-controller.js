
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
            mail: $scope.credentials.mail,
            password: $scope.credentials.password,
            rep_password: $scope.credentials.rep_password,
            first_name: $scope.credentials.first_name,
            last_name: $scope.credentials.last_name,
            phone_number: $scope.credentials.phone_number,
            latitude: $scope.credentials.latitude,
            longitude: $scope.credentials.longitude,
            address: $scope.geoloc,
            role: 'parent'
        };

        var address = $scope.details.geometry.location;

        request.latitude = address.lat();
        request.longitude = address.lng();

        console.log(request)

    }
});