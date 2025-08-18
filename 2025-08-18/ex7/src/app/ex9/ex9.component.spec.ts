import { ComponentFixture, TestBed } from '@angular/core/testing';

import { Ex9Component } from './ex9.component';

describe('Ex9Component', () => {
  let component: Ex9Component;
  let fixture: ComponentFixture<Ex9Component>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [Ex9Component]
    })
    .compileComponents();

    fixture = TestBed.createComponent(Ex9Component);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
