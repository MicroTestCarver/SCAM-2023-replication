import { test, expect } from '@playwright/test';

test('test', async ({ page }) => {
  await page.goto('http://localhost:8080/hello');
  await page.goto('http://localhost:8080/hello/peter');
  await page.goto('http://localhost:8080/hello/carter');
  await page.goto('http://localhost:8080/hello/pan');
  await page.goto('http://localhost:8080/weather');
});