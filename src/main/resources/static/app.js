var router = angular.module('router', [ 'ui.router', 'ngCookies', 'ngMessages']);


router.config(function($stateProvider, $urlRouterProvider, $compileProvider) {

    $urlRouterProvider.otherwise('/');

    $stateProvider

        .state('home', {
            url: '/',
            templateUrl: 'app/components/homepage/homepage.html',
            controller: 'homepageController',
            data: {pageTitle : ""}
        })
        .state('profile', {
            url: '/profile',
            templateUrl: 'app/components/profile/profile.html',
            controller: 'profileController',
            data: {pageTitle : "Profile"}
        });
});

router.run([
    '$log', '$rootScope', '$window', '$state', '$location',
    function($log, $rootScope, $window, $state, $location) {
        $rootScope.$on('$stateChangeStart', function(event, toState, toParams, fromState, fromParams) {
            if (toState.data.pageTitle ) {
                document.title = toState.data.pageTitle + ' | Kinderplan';

            }else
                document.title = 'Kinderplan';
        });
    }
]);
