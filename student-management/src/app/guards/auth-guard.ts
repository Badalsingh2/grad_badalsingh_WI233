import { inject } from '@angular/core';
import { CanActivateFn, Router } from '@angular/router';
import { Roleservice } from '../services/roleservice';

export const authGuard: CanActivateFn = (route, state) => {
  const rs = inject(Roleservice);
  const router = inject(Router);

  if(rs.getRole() === "Guest"){
    router.navigate(["/login"]);
    return false;
  }
  return true;
};
