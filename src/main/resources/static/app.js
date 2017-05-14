var router = angular.module('router', [ 'ui.router', 'ngRoute']);


router.config(function($stateProvider, $urlRouterProvider, $compileProvider) {

    $stateProvider

        .state('index', {
            views: {
                '': {
                    templateUrl: './components/nav-bar.html',
                    controller: 'navBarController'
                },


            }, data: {pageTitle: 'main'}
        });
};