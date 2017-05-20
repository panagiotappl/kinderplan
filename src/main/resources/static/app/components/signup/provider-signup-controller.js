
router.controller('providerSignupController', function($scope, $cookies, UserService){

    $scope.credentials = {
        company_name: '',
        mail: '',
        password: '',
        rep_password: '',
        first_name: '',
        last_name: '',
        phone_number: '',
        latitude: '',
        longitude: '',
        address: '',
        role: '',
        afm: ''
    };

    $scope.vaildateEmail = function(email) {
        var re = /^(([^<>()\[\]\\.,;:\s@"]+(\.[^<>()\[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
        return re.test(email);
    };


    $scope.signup = function() {
        var error = false;
        var miss_error = false;

        $scope.phone_number_error = false;
        $scope.pass_error = false;
        $scope.pass_len_error = false;
        $scope.mail_error= false;
        $scope.afm_error= false;

        $scope.options = {
            types: 'geocode',
            watchEnter: true,
            country: 'gr'
        };

        //UNCOMMENT FOLLOWING LINES TO ENABLE VALIDATIONS
        if ($scope.credentials.first_name === '') {
            $scope.first_name_missing_error = 'set';
            miss_error = true;
        }
        if ($scope.credentials.last_name === '') {
            $scope.last_name_missing_error = 'set';
            miss_error = true;
        }
        if ($scope.credentials.password === '') {
            $scope.password_missing_error = 'set';
            miss_error = true;
        }
        if ($scope.credentials.rep_password === '') {
            $scope.rep_password_missing_error = 'set';
            miss_error = true;
        }
        if ($scope.credentials.mail === '') {
            $scope.mail_missing_error = 'set';
            miss_error = true;
        }
        if ($scope.credentials.company_name === '') {
            $scope.company_name_missing_error = 'set';
            miss_error = true;
        }
        if ($scope.credentials.phone_number === '') {
            $scope.phone_number_missing_error = 'set';
            miss_error = true;
        }
        if ($scope.credentials.afm === '') {
            $scope.afm_missing_error = 'set';
            miss_error = true;
        }
        if ($scope.geoloc === '') {
            $scope.address_missing_error = 'set';
            miss_error = true;
        }

        if ($scope.credentials.phone_number.length < 10 && miss_error == false) {
            $scope.phone_number_error = 'set';
            error = true;
        }

        if ($scope.credentials.afm.length < 5 && miss_error == false) {
            $scope.afm_error = 'set';
            error = true;
        }

        if ($scope.credentials.password.length < 5 && miss_error == false) { // TODO: Should prevent pass_error to be sent.p
            $scope.pass_len_error = 'set';
            error = true;
        }

        if ($scope.credentials.password !== $scope.credentials.rep_password && miss_error == false) {
            $scope.pass_error = 'set';
            error = true;
        }

        if ($scope.vaildateEmail($scope.credentials.mail) != true && miss_error == false) {
            $scope.mail_error = 'set';
            error=true;
        }


        if (error ||  miss_error) return;

        var request = {
            company_name: $scope.credentials.company_name,
            mail: $scope.credentials.mail,
            password: $scope.credentials.password,
            rep_password: $scope.credentials.rep_password,
            first_name: $scope.credentials.first_name,
            last_name: $scope.credentials.last_name,
            phone_number: $scope.credentials.phone_number,
            latitude: $scope.credentials.latitude,
            longitude: $scope.credentials.longitude,
            address: $scope.geoloc,
            role: 'provider',
            afm: $scope.credentials.afm
        };

        var address = $scope.details.geometry.location;

        request.latitude = address.lat();
        request.longitude = address.lng();

        console.log(request)

    }
});