(function() {
  'use strict';

  var serverDomain = '//pet-server-team-2.pcf-apps.intware.com';
  
  angular
    .module('petClient')
    .controller('PetDeleteController', PetDeleteController);

  /** @ngInject */
  function PetDeleteController($log, $http, $modalInstance, pet) {
    var vm = this;
    vm.pet = pet;
    vm.deletePet = deletePet;
    vm.cancel = cancel;

    $log.info('Initializing pet delete modal controller with pet: ', vm.pet);

    function deletePet(petId) {
      $log.info("Deleting pet id: ", petId);
      var url = serverDomain + '/pet' + "/" + petId;
      $http.delete(url)
        .then(function () {
            $modalInstance.close(true);
          }
        ).catch(function (error) {
            $log.error('Error deleting pet: ', error);
            $modalInstance.close(false);
      });
    }

    function cancel() {
      $modalInstance.close(false);
    }

  }
})();
