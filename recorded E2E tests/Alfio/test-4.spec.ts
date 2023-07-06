import { test, expect } from '@playwright/test';

test('test', async ({ page }) => {
  await page.goto('http://localhost:8080/authentication');
  await page.getByLabel('Username').click();
  await page.getByLabel('Username').fill('admin');
  await page.getByLabel('Username').press('Tab');
  await page.getByLabel('Password').fill('admin');
  await page.getByLabel('Password').press('Enter');
  await page.getByLabel('Username').click();
  await page.getByLabel('Username').fill('admin');
  await page.getByLabel('Username').press('Tab');
  await page.getByLabel('Password').fill('1234');
  await page.getByLabel('Password').press('Enter');
  await page.getByLabel('Username').click();
  await page.getByLabel('Username').fill('admin');
  await page.getByLabel('Username').press('Tab');
  await page.getByLabel('Password').fill('abcd');
  await page.getByLabel('Password').press('Enter');
  await page.getByText('None').click();
  await page.getByText('Disabled').click();
  await page.getByText('Base application url system system').click();
  await page.getByLabel('Base application url system').fill('localhost');
  await page.getByRole('button', { name: 'save' }).click();
  await page.getByText('Organizations').click();
  await page.getByRole('link', { name: ' add new' }).click();
  await page.getByLabel('Name').fill('Scam');
  await page.getByLabel('Name').press('Tab');
  await page.getByLabel('Name').dblclick();
  await page.getByLabel('Name').fill('ScamI');
  await page.getByLabel('Name').press('Meta+a');
  await page.getByLabel('Name').fill('ICSME');
  await page.getByLabel('Name').press('Tab');
  await page.getByLabel('Contact E-Mail').fill('icsme@gmail.com');
  await page.getByRole('button', { name: 'Save' }).click();
  await page.getByRole('button', { name: 'Save' }).click();
  await page.getByLabel('Description').click();
  await page.getByLabel('Description').click();
  await page.getByLabel('Description').fill('The International Conference on Software Maintenance and Evolution is the premier international forum for researchers and practitioners from academia, industry, and government to present, discuss, and debate the most recent ideas, experiences, and challenges in software maintenance and evolution.');
  await page.getByRole('button', { name: 'Save' }).click();
  await page.getByText('Events').click();
  await page.getByRole('link', { name: 'Create new event', exact: true }).click();
  await page.getByLabel('Event Name').fill('SCAN');
  await page.getByPlaceholder('Please enter the address of the Location. This will be used for displaying the map on the event page.').click();
  await page.getByPlaceholder('Please enter the address of the Location. This will be used for displaying the map on the event page.').fill('Bogotá, Colombia');
  await page.getByLabel('English').click();
  await page.getByLabel('Event Date').click();
  await page.locator('div:nth-child(2) > .calendar-date > .table-condensed > thead > tr > .next > .fa').click();
  await page.locator('div:nth-child(2) > .calendar-date > .table-condensed > thead > tr > .next > .fa').click();
  await page.locator('div:nth-child(2) > .calendar-date > .table-condensed > thead > tr > .next > .fa').click();
  await page.getByRole('row', { name: '1 2 3 4 5 6 7' }).getByRole('cell', { name: '2' }).click();
  await page.getByRole('cell', { name: '3', exact: true }).first().click();
  await page.getByText('Basic info Event Name Event Organizer ICSME Event will be held in persononlinehy').click();
  await page.getByLabel('English').click();
  await page.getByLabel('English').fill('The aim of the International Working Conference on Source Code Analysis & Manipulation (SCAM) is to bring together researchers and practitioners working on theory, techniques and applications which concern analysis and/or manipulation of the source code of computer systems. While much attention in the wider software engineering community is properly directed towards other aspects of systems development and evolution, such as specification, design and requirements engineering, it is the source code that contains the only precise description of the behaviour of the system. The analysis and manipulation of source code thus remains a pressing concern.');
  await page.getByLabel('Website link').click();
  await page.getByLabel('Website link').fill('http://www.ieee-scam.org/2023/#');
  await page.getByLabel('Terms and Conditions URL').click();
  await page.getByLabel('Terms and Conditions URL').fill('http://www.ieee-scam.org/2023/#');
  await page.getByLabel('Privacy policy URL').click();
  await page.getByLabel('Privacy policy URL').fill('http://www.ieee-scam.org/2023/#');
  await page.getByText('Drop image here or click to upload (Maximum size : 200KB)').click();
  await page.locator('body').setInputFiles('SCAM_logo.png');
  await page.getByLabel('Max tickets').click();
  await page.getByLabel('Max tickets').fill('150');
  await page.getByLabel('Currency').click();
  await page.getByLabel('Currency').fill('Euro');
  await page.getByLabel('Taxes (%)').click();
  await page.getByLabel('Currency').click();
  await page.getByLabel('Currency').dblclick();
  await page.getByLabel('Regular Price').click();
  await page.getByLabel('Regular Price').fill('150');
  await page.getByLabel('Taxes (%)').click();
  await page.getByLabel('Taxes (%)').fill('0');
  await page.getByText('Accepted payment methods On site (cash) payment Offline payment (bank transfer, ').click();
  await page.getByLabel('Currency').click();
  await page.getByText('Ticket price model Entry fee requested Free of charge Max tickets Regular Price ').click();
  await page.getByText('On site (cash) payment').click();
  await page.getByLabel('Currency').click();
  await page.getByLabel('Currency').dblclick();
  await page.getByLabel('Currency').fill('e');
  await page.getByLabel('Currency').press('ArrowUp');
  await page.getByLabel('Currency').press('ArrowDown');
  await page.getByLabel('Currency').fill('doll');
  await page.getByLabel('Currency').press('ArrowDown');
  await page.getByLabel('Currency').press('ArrowDown');
  await page.getByLabel('Currency').press('ArrowDown');
  await page.getByLabel('Currency').press('ArrowDown');
  await page.getByLabel('Currency').press('ArrowDown');
  await page.getByLabel('Currency').press('ArrowDown');
  await page.getByLabel('Currency').press('Enter');
  await page.getByLabel('Currency').fill('EUR');
  await page.getByLabel('Currency').press('Enter');
  await page.getByRole('form').locator('div').filter({ hasText: 'Please define at least one category' }).nth(1).click();
  await page.getByRole('form').locator('div').filter({ hasText: 'Please define at least one category' }).nth(1).click();
  await page.getByRole('button', { name: ' Add new' }).click();
  await page.getByLabel('Name', { exact: true }).click();
  await page.getByLabel('Name', { exact: true }).fill('Early Bird');
  await page.getByRole('dialog').getByRole('button', { name: 'Save' }).click();
  await page.getByRole('button', { name: 'Save' }).click();
  await page.getByText('Publish now').click();
  await page.goto('http://localhost:8080/');
  await page.goto('http://localhost:8080/event/scan');
  await page.getByRole('combobox', { name: 'Quantity' }).selectOption('1');
  await page.getByRole('button', { name: 'Continue' }).click();
  await page.locator('#first-name').click();
  await page.locator('#first-name').fill('Peter');
  await page.locator('#first-name').press('Tab');
  await page.locator('#last-name').fill('Jackson');
  await page.locator('#last-name').press('Tab');
  await page.locator('#email').fill('peterjackson@gmail.com');
  await page.locator('app-ticket-form').getByLabel('Email *').click();
  await page.getByRole('button', { name: 'Continue' }).click();
  await page.getByText('I have read and agree to the privacy policy').click();
  await page.getByText('I have read and agree to the terms and conditions').click();
  await page.getByRole('button', { name: 'Confirm' }).click();
});