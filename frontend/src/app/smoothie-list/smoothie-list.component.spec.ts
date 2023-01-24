import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SmoothieListComponent } from './smoothie-list.component';

describe('SmoothieListComponent', () => {
  let component: SmoothieListComponent;
  let fixture: ComponentFixture<SmoothieListComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ SmoothieListComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(SmoothieListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
