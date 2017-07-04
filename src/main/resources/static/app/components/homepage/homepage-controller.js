router.controller('homepageController', function($scope, $cookies, UserService, EventsService, $state){
    $scope.selected = [];

    $scope.toggle = function (item, list) {
        var idx = list.indexOf(item);
        if (idx > -1) {
            list.splice(idx, 1);
        }
        else {
            list.push(item);
        }
    };

    $scope.exists = function (item, list) {
        return list.indexOf(item) > -1;
    };


    $scope.search = function(){
        $state.go('search', {query: $scope.searchQuery});
    }



    $scope.request = {};


    $scope.advanced = function(){
        $scope.options = {
            types: 'geocode',
            watchEnter: true,
            country: 'gr'
        };


        $scope.request.address = $scope.geoloc;
        if($scope.details !== undefined){
            var address = $scope.details.geometry.location;

            $scope.request.lat = address.lat();
            $scope.request.lon = address.lng();
        }
        if($scope.request.distance !== undefined)
            $scope.request.distance = parseInt($scope.request.distance);
        if($scope.date !== undefined)
            $scope.request.date_starting = new Date($scope.date.date_starting).getTime();
        if($scope.date !== undefined)
            $scope.request.date_ending = new Date($scope.date.date_ending).getTime();

        console.log($scope.request);
        $state.go('search', {query: $scope.request.text, lat: $scope.request.lat, lon: $scope.request.lon, dist: $scope.request.distance, start: $scope.request.date_starting, end: $scope.request.date_ending});

        EventsService.advanced($scope.request)
            .then(function(response){
                console.log(response);
            }, function(response){
                console.log(response);
            });

    }
});
