(function() {
  'use strict';

  angular
    .module('petClient')
    .controller('MainController', MainController);

  /** @ngInject */
  function MainController($rootScope, loginService, $location, $log) {
    var vm = this;

    vm.creationDate = 1458950758345;
    vm.login = login;
    vm.credentials = {};

    function login() {
      loginService.login(vm.credentials, function(authenticated) {
        if (authenticated) {
          $log.info("Login succeeded")
          $location.path("/add");
          vm.error = false;
          $rootScope.authenticated = true;
        } else {
          $log.info("Login failed")
          $location.path("/");
          vm.error = true;
          $rootScope.authenticated = false;
        }
      });
    }
  }
})();
