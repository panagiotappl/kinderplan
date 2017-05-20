/**
 * Created by Panos on 20/05/2017.
 */

router.controller('addEventController', function($scope, $cookies, UserService){

    $scope.credentials = {
        provider: '',
        eventName: '',
        ageFrom: '',
        ageTo: '',
        ticketPrice: '',
        description: '',
        latitude: '',
        longitude: '',
        address: '',
        startDate: null,
        endDate: null,
        dates: []

    };

    $scope.add = function(){
        var error = false;
        var miss_error = false;

        var request = $scope.credentials;

        request.createdDate = new Date();
        request.address = $scope.geoloc;

        $scope.options = {
            types: 'geocode',
            watchEnter: true,
            country: 'gr'
        };

        if (error ||  miss_error) return;

        var address = $scope.details.geometry.location;

        request.latitude = address.lat();
        request.longitude = address.lng();

        console.log(request)

    }

});

