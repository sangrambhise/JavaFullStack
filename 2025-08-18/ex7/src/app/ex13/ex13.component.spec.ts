import { ComponentFixture, TestBed } from '@angular/core/testing';

import { Ex13Component } from './ex13.component';

describe('Ex13Component', () => {
  let component: Ex13Component;
  let fixture: ComponentFixture<Ex13Component>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [Ex13Component]
    })
    .compileComponents();

    fixture = TestBed.createComponent(Ex13Component);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
